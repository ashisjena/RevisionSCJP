package scjp.com.java.chapterAnnotation;

import java.lang.annotation.Annotation;

@Version(major = 1)
@ChangeLog(date = "28-04-2019", comments = "This is a test comment")
@ChangeLog(date = "29-04-2019", comments = "This is one more dummy comment")
public class TestClass {

  @Version(major = 1, minor = 1)
  public static void main(String[] args) throws NoSuchMethodException {
    Class<TestClass> clazz = TestClass.class;
    /*Annotation[] annotations = clazz.getAnnotations();
    for(Annotation annot : annotations){
      System.out.println(annot.toString());
    }*/

    Version version = clazz.getAnnotation(Version.class);
    if (version == null) {
      System.out.println("Version annotation is not present");
    } else {
      int major = version.major();
      int minor = version.minor();
      System.out.println("Version for class type: major=" + major + ", minor=" + minor);
    }

    Version methodVersion = clazz.getMethod("main", String[].class).getAnnotation(Version.class);
    System.out.println(methodVersion.toString());

    System.out.println("Using ChangeLog Type");
    ChangeLog[] chgList = clazz.getAnnotationsByType(ChangeLog.class);
    for (ChangeLog clg : chgList) {
      System.out.println("Date=" + clg.date() + ", comments=" + clg.comments());
    }

    System.out.println("Using ChangeLogs Type");
    ChangeLogs changeLogs = clazz.getAnnotation(ChangeLogs.class);
    for (ChangeLog clg : changeLogs.value()) {
      System.out.println("Date=" + clg.date() + ", comments=" + clg.comments());
    }
  }
}

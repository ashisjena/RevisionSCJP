package scjp.com.java.javaLanguageFeatures.chapterAnnotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PACKAGE})
@Retention(RetentionPolicy.RUNTIME)
//@Inherited
@Documented
public @interface Version {
  int major();

  int minor() default 0;
}

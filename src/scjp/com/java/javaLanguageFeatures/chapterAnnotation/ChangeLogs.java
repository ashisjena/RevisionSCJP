package scjp.com.java.javaLanguageFeatures.chapterAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ChangeLogs {
  ChangeLog[] value();
}

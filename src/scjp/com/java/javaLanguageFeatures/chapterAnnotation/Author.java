package scjp.com.java.javaLanguageFeatures.chapterAnnotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Authors.class)
public @interface Author {
  String firstName();
  String lastName();
}

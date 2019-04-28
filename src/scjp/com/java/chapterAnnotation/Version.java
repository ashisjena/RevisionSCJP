package scjp.com.java.chapterAnnotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
//@Inherited
@Documented
public @interface Version {
  int major();

  int minor() default 0;
}

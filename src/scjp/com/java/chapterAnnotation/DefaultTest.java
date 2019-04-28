package scjp.com.java.chapterAnnotation;

import java.io.IOException;

public @interface DefaultTest {
  double dd();
  double d() default 12.89;
  int num() default 5;
  int[] x() default {1, 2};
  Class c() default Exception.class;
  Class[] c2() default {Exception.class, IOException.class};
}
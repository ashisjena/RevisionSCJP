package scjp.com.java.algorithm.old.companies;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

class FileBasedQueue<T extends Serializable> {

  ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
  Queue<String> fileQueue = new LinkedList<String>();
  File file = new File("FileBasedQueue.txt");
  RandomAccessFile randomAccessFile;
  Converter<T> converter = new Converter<T>();
  
  public FileBasedQueue() {
    try {
      this.file.createNewFile();
      randomAccessFile = new RandomAccessFile(file, "rwd");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
   
  public T add(T entity) throws IOException
  {
    byteArrayOutputStream.reset();
    converter.convert(entity, byteArrayOutputStream);
    randomAccessFile.write(byteArrayOutputStream.toByteArray());
    return entity;
  }

}


class Converter<T extends Serializable> {
  
  public void convert(T obj, OutputStream out) throws IOException {
    ObjectOutputStream oos = new ObjectOutputStream(out);
    oos.writeUnshared(obj);
    oos.close();
  }

  @SuppressWarnings("unchecked")
  public T deseralize(InputStream in) throws IOException {
    ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(in, 1024));
    try {
      T entity = (T) ois.readUnshared();
      ois.close();
      return entity;
    } catch (ClassNotFoundException e) {
      throw new AssertionError(e);
    }
  }
}

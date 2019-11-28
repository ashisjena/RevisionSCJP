package scjp.com.java.languageFundamentals.chapter9;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class CacheImpl<K, V>
{
    private final Map< K, V > cache;
    private final ReadLock readLock;
    private final WriteLock writeLock;

    {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        this.readLock = readWriteLock.readLock();
        this.writeLock = readWriteLock.writeLock();
    }

    public CacheImpl()
    {
        this.cache = new HashMap< K, V >();
    }

    public CacheImpl( Map< K, V > cache )
    {
        this.cache = cache;
    }

    public void put( K key, V value )
    {
        this.writeLock.lock();
        try
        {
            this.cache.put( key, value );
        }
        finally
        {
            this.writeLock.unlock();
        }
    }

    public V get( K key )
    {
        V value = null;
        this.readLock.lock();
        try
        {
            value = this.cache.get( key );
        }
        finally
        {
            this.readLock.unlock();
        }
        return value;
    }
}
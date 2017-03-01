
import com.danga.MemCached.MemCachedClient;
import com.worldlingo.wrapper.memcached.MemCachedManager;


public class MemcachedJava {
  public static void main(String[] args) {
    try{
      // Connecting to Memcached server on localhost
      MemCachedClient mcc = MemCachedManager.GetInstance().getClient("DictionaryVendorsCache");
      //mcc.add("webster", "webster test");
      System.out.println("Connection to server sucessful.");
      System.out.println(mcc.get("webster"));

      // Shutdowns the memcached client

    }catch(Exception ex){
      System.out.println( ex.getMessage() );
    }
  }
}
public class SortingAlgorithm implements Runnable{
  private float[] v;
  private Thread t;
  final static short DELAY = 10;

  SortingAlgorithm(float[] v){
    this.v = v;
  }

  @Override
  public void run(){
    // look into subclass
  }
  private void start(SortingAlgorithm sa){
    if(t == null){
      t = new Thread(sa);
      t.start();
    }
  }


  private void animate(){
    for(int i = 0; i < v.length; i++){
      try{ Thread.sleep(5); }
      catch (Exception e){}
      status[i] = 1;
    }
    t = null;
  }

  private void sleep(){
    try{ Thread.sleep(SortingAlgorithm.DELAY); }
    catch (Exception e){}

    try{while(pause){ Thread.sleep(100); }}
    catch (Exception e){}
  }

}

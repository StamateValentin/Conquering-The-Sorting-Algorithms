class SelectionSort extends SortingAlgorithm{

  @Override
  public void run() {
    for(int i = 0; i < v.length - 1; i++){

      status[i] = 1;

      for(int j = i + 1; j < v.length; j++){
        if(v[i] > v[j]){
          comparisons++;
          arrayAccess+=2;

          status[j] = 2;
          SoundPlay(i);

          super.sleep();
          swap(i, j);
        }
        status[j] = 0;
      }
      status[i] = 0;
    }

    if(sortStart){
      super.animate();
    }
    super.t = null;
    sortStart = false;
  }

  public void start(){
    super.start(this);
  }

}

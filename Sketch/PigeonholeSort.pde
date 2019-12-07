class PigeonholeSort extends SortingAlgorithm{

  @Override
  public void run() {

    algorithmFlag = "Algorithm : Pigeonhole Sort";

    pigeonholeSort();

    if(sortStart){
      super.animate();
    }
    super.t = null;
    sortStart = false;
  }

  public void start(){
    super.start(this);
  }

  void pigeonholeSort(){
    int min = v[0], max = v[0];
    comparisons+=2;

    for(int i = 1; i < v.length; i++){

      ArrayColor(i, 1);
      super.sleep();
      ResetArrayColor(i);

      if(v[i] < min){
        min = v[i];
        arrayAccess++;
      }
      if(v[i] > max){
        max = v[i];
        arrayAccess++;
      }
      arrayAccess+=2;
      comparisons+=2;
    }

    int range = max - min + 1;

    int[] pHole = new int[range];
    for(int i = 0; i < pHole.length; i++){
      pHole[i] = 0;
    }

    for(int i = 0; i < v.length; i++){
      ArrayColor(i, 3);
      super.sleep();
      ResetArrayColor(i);

      pHole[v[i] - min]++;
      arrayAccess++;
    }

    int index = 0;

    for(int i = 0; i < pHole.length; i++){
      while(pHole[i] > 0){
        v[index] = i + min;

        arrayAccess++;

        ArrayColor(index, 1);
        super.sleep();
        ResetArrayColor(index);

        index++;
        pHole[i]--;
      }
    }
  }

}

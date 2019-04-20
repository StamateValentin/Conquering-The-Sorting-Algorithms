class CockTailSort {
  constructor() {
  }

  async Sort() {

    let swapped = true;
    let start = 0;
    let end = v.length;

    while (swapped) {
      swapped = false;

      for (let i = start; i < end && isStarted; ++i) {
        status[i] = 4;

        if (v[i] > v[i + 1]) {
          await this.swap(i, i + 1);
          swapped = true;
        } else 
            await sleep();
        
        status[i] = 0;
      }
      if (!swapped)
        break;

      swapped = false;

      --end;

      for (let i = end - 1; i >= start && isStarted; --i) {
        status[i + 1] = 2;

        if (v[i] > v[i + 1]) {
          await this.swap(i, i + 1);
          swapped = true;
        } else 
            await sleep();
        
        status[i + 1] = 0;
      }

      ++start;

    }

    console.log("Cocktail Sort : Done");

    return true;
  }

  async swap(i, j) {
    await sleep();

    let aux = v[i];
    v[i] = v[j];
    v[j] = aux;
  }

}
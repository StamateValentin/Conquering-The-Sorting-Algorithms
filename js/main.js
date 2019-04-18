'use strict';
let v = new Array();
// 0 - normal , 1 - pivot, 2 - line to switch, 3 - where it goes?
let line_w = 3; //line width
let v_size, sector;
let algorithm_type = 'heap';
let algorithm_status = false;//if starts or not
let alg_finished = false;

let sort;

function setup(){
  createCanvas(1000,400);
  background(20);
  frameRate(60);
  sector = line_w + 2;
  v_size = width / sector - 2;  // a sector must be bigger than the line width in order to have a space betweel lines // -2 is for letting a space between canvas and lines
}

function draw(){
  background(20);

  checkAlgorithm(algorithm_type);


  for(let i = 0; i<v_size; i++){
    switch(sort.status[i]){
      case 0:
        stroke(255); break;
      case 1:
        stroke(63, 237, 124); break;
      case 2:
      stroke(237, 64, 64); break;
      case 3:
        stroke(74, 163, 247); break;
    }
    strokeWeight(line_w);
    line(i*sector + line_w/2 + line_w, height - line_w, i*sector + line_w/2 + line_w, height - v[i] - line_w);
  }


  function checkAlgorithm(type){
    if(alg_finished){
      noLoop();
      console.log("Done");
    } else if(type === 'selection'){
      if(!algorithm_status) {
        sort = new SelectionSort(v_size);
        algorithm_status = true;
      }
      v = sort.v;
      sort.Sort();
      
    } else if(type === 'bubble'){
      if(!algorithm_status) {
        sort = new BubbleSort(v_size);
        algorithm_status = true;
      }
      v = sort.v;
      sort.Sort();

    } else if(type === 'insertion'){
      if(!algorithm_status) {
        sort = new InsertionSort(v_size);
        algorithm_status = true;
      }
      v = sort.v;
      sort.Sort();

    } else if(type === 'quick'){//TO DO : DONE THING
      if(!algorithm_status) {
        sort = new QuickSort(v_size);
        algorithm_status = true;

        for(let i = 0; i < v_size; i++)
          v[i] = parseInt( random( height-30 ) );

        sort.Sort(v, 0, v_size);
      }
    } else if(type === 'cocktail'){
      if(!algorithm_status) {
        sort = new CockTailSort(v_size);
        algorithm_status = true;

        for(let i = 0; i < v_size; i++)
          v[i] = parseInt( random( height-30 ) );

        sort.Sort(v);
      }
      if(sort.finished)
        alg_finished = true;
      
    } else if(type === 'merge'){
      if(!algorithm_status) {
        sort = new MergeSort(v_size);
        algorithm_status = true;


        for(let i = 0; i < v_size; i++)
          v[i] = parseInt( random( height-30 ) );

        sort.Sort(v, 0, v_size - 1);
      }
      if(sort.finished)
        alg_finished = true;
      
    } else if(type === 'heap'){
      if(!algorithm_status) {
        sort = new HeapSort(v_size);
        algorithm_status = true;


        for(let i = 0; i < v_size; i++)
          v[i] = parseInt( random( height-30 ) );

        sort.Sort(v, 0, v_size - 1);
      }
      if(sort.finished)
        alg_finished = true;
      
    }

   

  }

}
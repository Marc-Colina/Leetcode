function reverseArray(array = []) {
  let startCounter = 0;
  let endCounter = array.length - 1;

  while (startCounter < endCounter) {
    let temp = array[startCounter];
    array[startCounter] = array[endCounter];
    array[endCounter] = temp;
    startCounter++;
    endCounter--;
  }
  return array;
}

console.log(reverseArray([189, 4, 2, 5, 1, 23, 4, 1, 2, 2]));

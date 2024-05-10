function arrayPairs(arrayOfNumbers) {
  for (let outerNum of arrayOfNumbers) {
    for (let innerNum of arrayOfNumbers) {
      console.log(outerNum + "" + innerNum);
    }
  }
}

arrayPairs([1, 3, 4, 5]);

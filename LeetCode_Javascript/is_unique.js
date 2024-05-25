function is_unique(arrayOfNumbers) {
  for (let outer = 0; outer < arrayOfNumbers.length; outer++) {
    for (let inner = outer + 1; inner < arrayOfNumbers.length; inner++) {
      arrayOfNumbers[outer] === arrayOfNumbers[inner];
      if (arrayOfNumbers[outer] === arrayOfNumbers[inner]) {
        return false;
      }
    }
  }
  return true;
}

console.log(is_unique([4, 1, 2, 3, 4, 5, 6]));

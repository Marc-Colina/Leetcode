//This is assuming that the numbers are sorted
//Solution 1 (LESS difficult but LESS efficient - O(n))
function missingNumberEasy(arrayOfNumbers) {
  let counter = 1;
  for (let index = 0; index < arrayOfNumbers.length; index++) {
    if (arrayOfNumbers[index] != counter) {
      return counter;
    }
    counter++;
  }
  return counter;
}

// //Alternate Solution (MORE complicated but MORE efficient - O(log n))
function missingNumber(arrayOfNumbers) {
  let a = arrayOfNumbers.length - 1;
  let b = 0;
  let index = 0;

  if (arrayOfNumbers[b] !== 1) return 1;
  else if (arrayOfNumbers[a] !== arrayOfNumbers.length + 1) {
    return arrayOfNumbers.length + 1;
  }

  while (true) {
    index = ((a + b) / 2) | 0;
    if (arrayOfNumbers[index] === index + 1) {
      if (index === b) return b + 2;
      b = index;
    } else {
      if (index === a) return a + 2;
      a = index;
    }
  }
}

//This is assuming the numbers are not sorted
function missingNumberUnsorted(arrayOfNumbers) {
  let sumOfNumbers = 0;
  let number = 1;
  let total = 0;

  for (let num of arrayOfNumbers) {
    sumOfNumbers += num;
    total += number;
    number++;
  }

  return total + number - sumOfNumbers;
}

arrayOfNumbers = [
  1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
  23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41,
  42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
  61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79,
  80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98,
  99,
];

arrayOfNumbers2 = [1, 10, 9, 4, 5, 3, 2, 6, 7];

console.log(missingNumberEasy(arrayOfNumbers));
console.log(missingNumber(arrayOfNumbers));
console.log(missingNumberUnsorted(arrayOfNumbers2));

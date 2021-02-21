function print(str) {
  console.log(str);
}

function printLinked(list) {
  var result = '';
  while (l) {
    result += l.val;
    if (l.next) result += '->';
    l = l.next;
  }
  console.log(result);
}

/**
 * Definition for singly-linked list.
 */
function ListNode(val) {
  this.val = val;
  this.next = null;
}

/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
  // pop the top of each

  var res = new ListNode(null);
  var currNode = res;

  var head1 = l1;
  var head2 = l2;
  if (head1 == null && head2 == null) return null;
  // print(head1);

  while (head1 !== null || head2 !== null) {
    // null check should be first
    if (head2 === null || (head1 !== null && head1.val <= head2.val)) {
      currNode.val = head1.val;
      head1 = head1.next;
    } else if (head1 === null || (head2 !== null && head2.val < head1.val)) {
      currNode.val = head2.val;
      head2 = head2.next;
    }

    if (head1 === null && head2 === null) {
      break;
    }
    // repeat
    currNode.next = new ListNode(null);
    currNode = currNode.next;
  }

  return res;
};

function print(l) {
  var result = '';
  while (l) {
    result += l.val;
    if (l.next) result += '->';
    l = l.next;
  }
  console.log(result);
}

var l1 = new ListNode(null);
// l1.next = new ListNode(2);
// l1.next.next = new ListNode(4);
// print(l1);

var l2 = new ListNode(null);
// l2.next = new ListNode(3);
// l2.next.next = new ListNode(4);

print(mergeTwoLists(l1, l2));

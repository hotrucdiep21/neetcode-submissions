class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        int sum = 0;
        for (String op : operations) {
            if (op.matches("-?\\d+")) {
                int val = Integer.parseInt(op);
                stack.push(val);
            } else {
                switch (op) {
                    case "+":
                        int firstVal = stack.pop();
                        int afterVal = stack.peek();
                        stack.push(firstVal);
                        stack.push(firstVal + afterVal);
                        break;
                    case "C":
                        stack.pop();
                        break;
                    case "D":
                        stack.push(stack.peek() * 2);
                        break;
                }
            }
        }
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
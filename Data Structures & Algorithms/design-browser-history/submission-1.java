
class BrowserHistory {
    private Stack<String> backStack;
    private Stack<String> forwardStack;

    public BrowserHistory(String homepage) {
        this.backStack = new Stack<>();
        this.forwardStack = new Stack<>();

        backStack.push(homepage);
    }

    public void visit(String url) {
        backStack.push(url);
        forwardStack.clear();
    }

    public String back(int steps) {
        for (int i = 0; i < steps; i++) {
            if (backStack.size() == 1) {
                break;
            }
            forwardStack.push(backStack.pop());
        }

        if (backStack.isEmpty()) {
            return "";
        } else {
            return backStack.peek();
        }
    }

    public String forward(int steps) {
        for (int i = 0; i < steps; i++) {
            if (forwardStack.isEmpty()) {
                break;
            }
            backStack.push(forwardStack.pop());
        }
        if (backStack.isEmpty()) {
            return "";
        } else {
            return backStack.peek();
        }
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
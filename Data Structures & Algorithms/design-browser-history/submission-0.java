class Browser {
    Browser prev;
    Browser next;
    String url;

    Browser(String url) {
        this.url = url;
    }
}
class BrowserHistory {
    Browser current;

    public BrowserHistory(String homepage) {
        current = new Browser(homepage);
    }

    public void visit(String url) {
        Browser newBrowser = new Browser(url);
        current.next = newBrowser;
        newBrowser.prev = current;
        current = newBrowser;
    }

    public String back(int steps) {
        Browser curr = current;
        for (int i = 0; i < steps; i++) {
            if(curr.prev == null) {
                break;
            }
            curr = curr.prev;
        }
        current = curr;
        return curr.url;
    }

    public String forward(int steps) {
        Browser curr = current;
        for(int i = 0; i < steps; i++) {
            if(curr.next == null) {
                break;
            }
            curr = curr.next;
        }
        current = curr;
        return current.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
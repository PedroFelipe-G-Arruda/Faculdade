class Stack:

    def __init__(self,inico):
        self.stack = []
        self.stack.append("$")
        self.stack.append(inico)

    def push(self, data):
        self.stack.append(data)
        return True

    def pop(self):
        return self.stack.pop()

    def size(self):
        return len(self.stack)

    def isEmpty(self):
        return self.stack == []

    def top(self):
        return self.stack[-1]
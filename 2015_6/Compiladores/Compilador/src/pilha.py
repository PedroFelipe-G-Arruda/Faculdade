class Stack:

    def __init__(self):
        self.stack = []

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
        if self.stack:
            return self.stack[-1]
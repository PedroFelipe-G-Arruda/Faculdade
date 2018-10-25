class Stack:

    def __init__(self,inico):
        self.stack = []
        self.stack.append("$")
        self.stack.append(inico)

    def push(self, data):
        self.stack.append(data)
        return True

    def pop(self):
        if len(self.stack) <= 0:
            return "Stack Empty!"
        return self.stack.pop()

    def size(self):
        return len(self.stack)

    def isEmpty(self):
        if not self.stack:
            return True
        return False

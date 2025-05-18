class Singleton:
    _instance = None

    def __init__(self, id: int, name: str):
        self.id = id
        self.name = name

    @classmethod
    def get_instance(cls, id: int, name: str):
        if cls._instance is None:
            cls._instance = Singleton(id, name)
        return cls._instance

x = Singleton.get_instance(1, "foo")
y = Singleton.get_instance(2, "bar")
print(f"x == y: {x == y}") # True
print(f"x is y: {x is y}") # True
print(f"id(x) == id(y): {id(x) == id(y)}") # True, compares memory location
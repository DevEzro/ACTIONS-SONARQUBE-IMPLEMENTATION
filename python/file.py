def test_sum():
    a, b = 12, 31
    result = a + b
    print(f"{a} + {b} = {result}")
    assert result == 43 # nosec -> especifica a bandit que no es para un test de seguridad
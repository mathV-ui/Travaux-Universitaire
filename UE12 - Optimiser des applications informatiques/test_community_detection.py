# Make your tests here

from community_detection import *

#Question 1
def test_create_network():
    list_of_friends =["Alice","Dominique","Alice","Bob","Charlie","Bob","Bob","Dominique"]
    assert create_network(list_of_friends) == {
        'Alice': ['Dominique', 'Bob'],
        'Dominique': ['Alice', 'Bob'],
        'Bob': ['Alice', 'Charlie', 'Dominique'], 
        'Charlie': ['Bob']
        }
    print("def create_network() ok !")

#Question 3
def test_get_people():
    network=    {
         "Alice" : ["Dominique","Bob"],
         "Bob" : ["Alice", "Dominique", "Charlie"],
          "Charlie" : ["Bob"],
          "Dominique" : ["Bob", "Alice"]
        }
    assert get_people(network) == ["Alice","Bob","Charlie","Dominique"]
    print("def get_people() ok !")

#Question 4
def test_are_friends():
    network=    {
         "Alice" : ["Dominique","Bob"],
         "Bob" : ["Alice", "Dominique", "Charlie"],
          "Charlie" : ["Bob"],
          "Dominique" : ["Bob", "Alice"]
        }
    assert are_friends(network,"Alice","Bob") == True
    assert are_friends(network,"Alice","Charlie") == False
    print("def are_friends() ok !")

#Question 5
def test_all_his_friends():
    network=    {
         "Alice" : ["Dominique","Bob"],
         "Bob" : ["Alice", "Dominique", "Charlie"],
          "Charlie" : ["Bob"],
          "Dominique" : ["Bob", "Alice"]
        }
    assert all_his_friends(network,"Alice",["Bob", "Dominique"]) == True
    assert all_his_friends(network,"Alice",["Bob", "Charlie"]) == False
    print("def all_his_friends() ok !")

#Question 6
def test_is_a_community():
    network=    {
         "Alice" : ["Dominique","Bob"],
         "Bob" : ["Alice", "Dominique", "Charlie"],
          "Charlie" : ["Bob"],
          "Dominique" : ["Bob", "Alice"]
        }
    assert is_a_community(network,["Alice", "Bob", "Dominique"]) == True
    assert is_a_community(network,["Alice", "Bob", "Charlie"]) == False
    print("def is_a_community() ok !")

#Question 7
def test_find_community():
    network=    {
         "Alice" : ["Dominique","Bob"],
         "Bob" : ["Alice", "Dominique", "Charlie"],
          "Charlie" : ["Bob"],
          "Dominique" : ["Bob", "Alice"]
        }
    assert find_community(network,["Alice", "Bob", "Charlie", "Dominique"]) == ["Alice", "Bob", "Dominique"]
    assert find_community(network,["Charlie", "Alice", "Bob", "Dominique"]) == ["Charlie", "Bob"]
    assert find_community(network,["Charlie", "Alice", "Dominique"]) == ["Charlie"]
    print("def find_community() ok !")

#Question 8
def test_order_by_decreasing_popularity():
    network=    {
         "Alice" : ["Dominique","Bob"],
         "Bob" : ["Alice", "Dominique", "Charlie"],
          "Charlie" : ["Bob"],
          "Dominique" : ["Bob", "Alice"]
        }
    assert order_by_decreasing_popularity(network,["Alice", "Bob", "Charlie"]) == ["Bob", "Alice", "Charlie"]
    print("def order_by_decreasing_popularity() ok !")

#Question 9
def test_find_community_by_decreasing_popularity():
    network=    {
         "Alice" : ["Dominique","Bob"],
         "Bob" : ["Alice", "Dominique", "Charlie"],
          "Charlie" : ["Bob"],
          "Dominique" : ["Bob", "Alice"]
        }
    assert find_community_by_decreasing_popularity(network) == ["Bob", "Alice", "Dominique"]
    print("def find_community_by_decreasing_popularity() ok !")

#Question 10
def test_find_community_from_person():
    network=    {
         "Alice" : ["Dominique","Bob"],
         "Bob" : ["Alice", "Dominique", "Charlie"],
          "Charlie" : ["Bob"],
          "Dominique" : ["Bob", "Alice"]
        }
    assert  find_community_from_person(network,"Alice") == ["Alice", "Bob", "Dominique"]
    assert  find_community_from_person(network,"Charlie") == ["Charlie", "Bob"]
    print("def find_community_from_person() ok !")

#Question 12
def test_find_max_community():
    network=    {
         "Alice" : ["Dominique","Bob"],
         "Bob" : ["Alice", "Dominique", "Charlie"],
          "Charlie" : ["Bob"],
          "Dominique" : ["Bob", "Alice"]
        }
    assert find_max_community(network) == ["Alice", "Bob", "Dominique"]
    print("def find_max_community() ok !")


if __name__ == "__main__":
    test_create_network()
    test_get_people()
    test_are_friends()
    test_all_his_friends()
    test_is_a_community()
    test_find_community()
    test_order_by_decreasing_popularity()
    test_find_community_by_decreasing_popularity()
    test_find_community_from_person()
    test_find_max_community()
    print("test_community_detection.py ok !")
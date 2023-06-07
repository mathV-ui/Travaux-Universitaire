##############
# SAE S01.01 #
##############

def liste_amis(amis, prenom):
    """
        Retourne la liste des amis de prenom en fonction du tableau amis.
    """
    prenoms_amis = []
    i = 0
    while i < len(amis)//2:
        if amis[2 * i] == prenom:
            prenoms_amis.append(amis[2*i+1])
        elif amis[2*i+1] == prenom:
            prenoms_amis.append(amis[2*i])
        i += 1
    return prenoms_amis

def nb_amis(amis, prenom):
    """ Retourne le nombre d'amis de prenom en fonction du tableau amis. """
    return len(liste_amis(amis, prenom))


def personnes_reseau(amis):
    """ Retourne un tableau contenant la liste des personnes du réseau."""
    people = []
    i = 0
    while i < len(amis):
        if amis[i] not in people:
            people.append(amis[i])
        i += 1
    return people

def taille_reseau(amis):
    """ Retourne le nombre de personnes du réseau."""
    return len(personnes_reseau(amis))

def lecture_reseau(path):
    """ Retourne le tableau d'amis en fonction des informations contenues dans le fichier path."""
    f = open(path, "r")
    l = f.readlines()
    f.close()
    amis = []
    i = 0
    while i < len(l):
        fr = l[i].split(";")
        amis.append(fr[0].strip())
        amis.append(fr[1].strip())
        i += 1
    return amis

def dico_reseau(amis):
    """ Retourne le dictionnaire correspondant au réseau."""
    dico = {}
    people = personnes_reseau(amis)
    i = 0
    while i < len(people):
        dico[people[i]] = liste_amis(amis, people[i])
        i += 1
    return dico

def nb_amis_plus_pop (dico_reseau):
    """ Retourne le nombre d'amis des personnes ayant le plus d'amis."""
    personnes = list(dico_reseau)
    maxi = len(dico_reseau[personnes[0]])
    i = 1
    while i < len(personnes):
        if maxi < len(dico_reseau[personnes[i]]):
            maxi = len(dico_reseau[personnes[i]])
        i += 1
    return maxi


def les_plus_pop (dico_reseau):
    """ Retourne les personnes les plus populaires, c'est-à-dire ayant le plus d'amis."""
    max_amis = nb_amis_plus_pop(dico_reseau)
    most_pop = []
    personnes = list(dico_reseau)
    i = 1
    while i < len(personnes):
        if len(dico_reseau[personnes[i]]) == max_amis:
            most_pop.append(personnes[i])
        i += 1
    return most_pop


##############
# SAE S01.02 #
##############

#Question 1
def create_network(list_of_friends):
    """Creation d'un dictionnaire a partir d'un tableau, a l'aide d'une boucle et plusieur condition"""
    i=0 #variable pour cible
    dico = {} #creation d'un dictionnaire vide
    for personne in list_of_friends: #boucle for pour chaque personne du tableau
        if i%2==0: #premiere condition avec modulo pour connaitre si la cible est paire ou impaire
            if personne in dico.keys():#deuxieme condition pour voir si l'element existe deja dans le dico
                dico[personne]+=[list_of_friends[i+1]]#ajoute car paire
            else:#deuxieme condition
                dico[personne]=[list_of_friends[i+1]]#ajoute car paire
        else:#premiere condition
            if personne in dico.keys():#deuxieme condition pour voir si l'element existe deja dans le dico
                dico[personne]+=[list_of_friends[i-1]]#decremente car impaire
            else:#deuxieme condition
                dico[personne]=[list_of_friends[i-1]]#decremente car impaire
        i+=1 #ajout +1 car changement de cible
    return dico


#Question 3
def get_people(network):
    """ retourn les clés de tab, dans un tableau, grave a .keys(). Prenant en paramètre un réseau et retournant la liste des personnes de ce réseau dans un tableau.puis la list() pour qu'elle soit accessible dans les autres version de python """
    return list(network.keys())

#Question 4
def are_friends(network, person1, person2):
    """La condition if in indique si p2 se trouve dans la value de la clé p1. Prenant en paramètre un réseau et deux personnes, retourne True si p2 est dans P1 et False sinon.  """
    if person2 in network[person1]: #condition if in
        return True  
    return False

#Question 5
def all_his_friends(network, person, group):
    """La boucle For va pour chaque personne de g : groupe, filtrer avec la condition if not in. Si une personne n'est pas amis avec elle, la def return False et si la boucle for se termine sans passer la condition if, alors elle retourn True"""
    for personne in group: #boucle For pour chaque personne dans groupe
        if personne not in network[person]: # condition if not in pour verifier si il s'y trouve pas
            return False
    return True

#Question 6
def is_a_community(network, group):
    """une boucle for va pour chaque personne du groupe, verifier avec la def all_his_friends, la valeur booleene. Si la def all_his_friends retourne une seul fois un False, la boucle sarrete et return un False, sinon return un True lorsque la boucle a tout fait sans probleme. """
    i=0 #variable pour situer la cible dans le groupe
    for personne in group: # boucle for de chaque personne dans groupe
        group.pop(i) #pop de la cible pour eviter des erreurs, car la cible de ne psa etre en amis avec elle meme.
        result = all_his_friends(network,personne,group) # appel de la def all_his_friends, pour la valeur Booleene.
        group.append(personne) #rajout de la cible dans le tableau
        i+=1 # variable +1 pour changer de cible
        if result == False: # condition qui verifie la valeur du resultat de la def all_his_friends.
            return False
    return True

#Question 7
def find_community(network, group):
    """une boucle while va pour chaque personne apres la premiere, verifier si la def all_his_friends retourne un false, si oui alors il append la personne. puis retourne le resultat"""
    result=[group[0]] #tableau de depars avec la premiere personnne
    i=1 # variable pour la cible dans le tableau et la boucle
    while i<len(group): #boucle de i < a la taille du groupe
        if all_his_friends(network,group[i],result)==True: # condition if de la def all_his_friends == a False.
            result.append(group[i]) #ajout de la cible a result 
        i+=1 # +1 pour la boucle et changer de cible dans le groupe
    return result

#Question 8
def order_by_decreasing_popularity(network, group):
    """une boucle incrementer dans une autre la premiere va changer de cible et echanger les place. et la deuxieme va comparer deux cible a chaque fois"""
    i=0 #variable demarre a 0
    while i<len(group): #premiere boucle
        tmp=i # variable temporaire
        n=i # variable pour comparer dans la seconde boucle
        while n<len(group): #boucle incrementer/ seconde boucle qui fait la comparaison de deux cible avec >.
            if len(network[group[n]])>len(network[group[tmp]]): # condition comparaison >
                tmp=n # variable change
            n+=1 #variable +1 pour changer de cible
        a=group[i] #pour deplacement dans le tableau
        group[i]=group[tmp]#pour deplacement dans le tableau
        group[tmp]=a#pour deplacement dans le tableau
        i+=1 # ajout +1 pour la boucle 
    return group

#Question 9
def find_community_by_decreasing_popularity(network):
    """ici nous retournons directement le resultat de la def find_community, qui elle meme prend en parramettre le reseau et la def order_by_decreasing_popularity, qui elle meme prend en parramettre le reseau et la def get_people"""
    return find_community(network,order_by_decreasing_popularity(network,get_people(network)))#3 def sont ici find_community, order_by_decreasing_popularity, get_people.

#Question 10
def find_community_from_person(network, person):
    """cette fonction retourne un tableau ed la cible et de ses amis en ordre croissant popularité. on creer dabord le tableau avec la cible en premier, puis on appel la fonction order_by_decreasing_popularity et une boucle for ajoute les personne de la meme communauté."""
    result=[person] #creation de la tab puis integration de la cible
    order_by_decreasing_popularity(network,network[person]) #appel de la def order_by_decreasing_popularity
    for personne in network[person]:#boucle for pour personne dans le reseau[personne]
        if all_his_friends(network,personne,result)==True:#condition pour ajouterdans le tableau
            result.append(personne)#ajoute dans le tableau
    return result

#Question 12
def find_max_community(network):
    """creation d'un tableau de la plus grande communauté, avec une boucle et une condition et appel de deux def."""
    tab=[] #creation du tableau
    for personne in get_people(network): #boucle for personne dans le tableau get_people(reseau)
        tab_temp = find_community_from_person(network,personne) # initialise une table temporaire pour la condition en dessous
        if len(tab_temp )>len(tab): #condition pour filtrer la plus grande comunauté
            tab=tab_temp #initialisation de la tab avec la plus taille taille
    return tab

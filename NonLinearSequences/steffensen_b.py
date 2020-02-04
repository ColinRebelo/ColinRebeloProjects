#Colin Rebelo 100699820


import math

def function(x):
    return math.exp(-(x**2) + x) - x/2 - 1.0836
def functionPrime(x):
    return (1-2*x) * math.exp(x - (x**2)) - 1/2


#Inputs the intial x, a function, the functions derivative, the maximum error, and the maximum iteration count
#Returns the x value obtained, the error and residule with that x value
def steffensen(x, function, functionPrime, maxErr, maxIteration):
    #Loops for the iterations
    for i in range(maxIteration):
        y1 = x #Assigns the old value for calculations

        y2 = (y1 - (function(y1) / functionPrime(y1))) #Newton step 1
        y3 = (y2 - (function(y2) / functionPrime(y2))) #Newton step 2

        x = y1 - (((y2 - y1) ** 2)/ (y3 - (2*y2) + y1)) #Calulculates the new x
        error = abs(x - y1) #Gets the error
        res = abs(function(x)) #Gets the residual
        print("Iteration:", i, "x =", x, "Error =", error, "Residual =", res)

        if abs(function(x)) < maxErr: #Checks if the value is within range
            print("Converged!")
            break
        
        if i+1 == maxIteration: #Checks if the iteration count is reached
            print("Max Iterations Reached")
            break

    return x,error,res


#Inputs the intial x, a function, the functions derivative, the maximum error, the maxmimum tolerance and the maximum iteration count
#Returns the x value obtained, the error and residule with that x value
def newtonIteration(x,function,functionPrime,maxErr,maxTol,maxIteration):
    y = x                                                                                      
    for i in range(1,maxIteration): #Loops for the iterations
        res = function(y) #Calculates the residual                           
        deltaX = -res/functionPrime(y)                                     
        y = y + deltaX         #Step used to update 
        res = abs(function(y)) #This res is used in the calculation furthur on                                   
        error = abs(deltaX)                                    
        print("Iteration:", i, "x =", x, "Error =", error, "Residual =", res)   #output's data                             
       
        if error < maxTol and res < maxErr: #Checks if the value is within range
            print("Converged")                   
            break                                         
        if i+1 == maxIteration: #Outputs the max iterations reached if the max are reached
            print("Max iterations reached")
            break
    
    return y,error,res

#Main

#Assigning values
x = 1
maxErr = 10E-15
maxTol = 10E-15
maxIteration = 10

x,error,res = newtonIteration(x, function, functionPrime, maxErr, maxTol, maxIteration)

print("Converged to: ", x, "with a residual of: ", res, " and an error of: ", error)
print("")


print("This does not show a quadratic convergence.")
print("")

x = 1
maxErr = 10E-15
maxIteration = 10

x,error,res = steffensen(x, function, functionPrime, maxErr, maxIteration)

print("Converged to: ", x, "with a residual of: ", res, " and an error of: ", error)
print("")


print("Steffensen approaches the quadratic convergence, but Newton’s does not. The reason being the condition number 1 / abs(f’(x)) is too large.")

#Colin Rebelo 100699820

import math

def function(x):
    return math.exp(-(x**2) + x) - x/2 - 1.0836

def functionPrime(x):
    return (1-2*x) * math.exp(x - (x**2)) - 1/2


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
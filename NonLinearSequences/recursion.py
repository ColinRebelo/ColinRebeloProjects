#Colin Rebelo 100699820


import math

def residual(x):
    return abs(math.sin(math.pi * x) - x**2)

def function(x): #Function used for the calculation
    return ((1/(2*math.pi) * math.sin(math.pi * x)) - (1/(2 * math.pi) * x**2) + x)


#Function takes inputs intial x, maxIterations, Maximum error, maximum Residule, and the Iteration count
#Returns the x value obtained, the error and residule with that x value
def recursive_m(x, maxIter, maxErr, maxRes,IterationCount):
    print("Iteration: ", IterationCount, " x value: ", x) #Outputs the data
    y = x #Used in the error calculation
    x = function(x) #Calculates the new x value
    error = abs(x-y) #Calculates the error
    res = residual(x) #Calculates the residual
    if maxIter > 0: #Checks if the maximum amount of iterations has been reached
        if(error < maxErr and res < maxRes): #Checks if the error and residual are within range
            print("Converges!")
            #Returns given that the error and residual are small enough
            return x,error,res
        #Increases iteration can creates recursive call given that it is not accurate enough
        IterationCount += 1
        x,error,res = recursive_m(x, maxIter-1, maxErr, maxRes, IterationCount)
    
    return x,error,res
#Main

#Assigning values
x = 1.5
maxIter = 25  
maxErr = 10E-10
maxRes = 10E-10
IterationCount = 0

#Assigns values given from the function
x,error,res = recursive_m(x,maxIter,maxErr,maxRes,IterationCount)

#Outputs the final result
print("Converged to: ", x, "with a residual of: ", res, " and an error of: ", error)


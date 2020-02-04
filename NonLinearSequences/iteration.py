#Colin Rebelo 100699820


import math

def residual(x):
    return abs(math.sin(math.pi * x) - x**2)

#Function takes inputs intial x, maxIterations, Maximum error and the maximum Residule
#Returns the x value obtained, the error and residule with that x value
def iteration_m(x, maxIter, maxErr, maxRes): # Iteration uses a for loop while recursion uses a recursive call
    for j in range(maxIter): #Loops for the amount of iterations speicifed (at most)
        print("Iteration: ", j, " x value: ", x) #Outputs the data
        y = x #Used in the error calculation
        x = function(x) #Calculates the new x value
        error = abs(x - y) #calculates the error
        res = residual(x) #Calculates the residual
        
        if(error < maxErr and res < maxRes): #Checks if the error and residual are within range
            print("Converged!")
            break #Breaks the loop given the value is within range

    return x, error, res

def function(x): #Function used to calculate
    return ((1/(2*math.pi) * math.sin(math.pi * x)) - (1/(2 * math.pi) * x**2) + x)


#Main

#Assigning values
x = 1.5
maxIter = 25  
maxErr = 10E-10
maxRes = 10E-10
#Assigns values recieved from the function
x,error,res = iteration_m(x,maxIter,maxErr,maxRes)


#Outputs the final results
print("Converged to: ", x, "with a residual of: ", res, " and an error of: ", error)
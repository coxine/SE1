def validateName(name, id):
    # id=0 first id=1 last
    nameParts = ["first", "last"]
    if len(name) == 0:
        print("The {0} name must be filled in.".format(nameParts[id]))
        return

    if len(name) < 2:
        print(
            '"{0}" is not a valid {1} name. It is too short.'.format(
                name, nameParts[id]
            )
        )


def validateZipCode(zipcode):
    if not zipcode.isnumeric():
        print("The ZIP code must be numeric.")


def validateID(id):
    if len(id) <= 6:
        print("{0} is not a valid ID.".format(id))
        return
    if not id[0].isalpha() or not id[1].isalpha():
        print("{0} is not a valid ID.".format(id))
        return
    if id[2] != "-":
        print("{0} is not a valid ID.".format(id))
        return
    if not id[3:6].isnumeric():
        print("{0} is not a valid ID.".format(id))
        return


def validate():
    FirstName = input("Enter the first name: ")
    LastName = input("Enter the last name: ")
    ZipCode = input("Enter the ZIP code: ")
    EmployeeID = input("Enter an employee ID: ")
    validateName(FirstName, 0)
    validateName(LastName, 1)
    validateZipCode(ZipCode)
    validateID(EmployeeID)

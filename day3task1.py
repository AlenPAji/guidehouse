
hospitals = [] 
with open("hospital.txt", "r") as file:
    lines = file.readlines()
    for line in lines:
        parts = line.strip().split("|")
        if len(parts) >= 4:  
            hospital_data = [
                parts[0],  
                parts[1],  
                parts[2],  
                parts[3]   
            ]
            hospitals.append(hospital_data)

print("Hospital Names:")
for hospital in hospitals:
    print(hospital[1])  

for hospital in hospitals:
    if hospital[1].lower() == "medical college":
        with open("contact.txt", "w") as contact_file:
            contact_file.write(hospital[3])
        break



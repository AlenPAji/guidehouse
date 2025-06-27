function guideHouse() {
  
  const str = "Guidehouse India";
  const str2 = "Technology";
  const words = str.split(" "); 

  
  const newStr = words[0] +" "+ str2;
  console.log("Modified String:", newStr);

  const techLength = str2.length;
  console.log("length of "+str2+" is", techLength);
}

guideHouse();

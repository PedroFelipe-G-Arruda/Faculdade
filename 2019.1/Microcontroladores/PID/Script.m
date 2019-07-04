clear all
clc
  if ~isempty(instrfind)
       fclose(instrfind);
      delete(instrfind);
  end
s = serial('COM3');
set(s,'BaudRate',9600)

fopen(s)
out=[];
while str2double(fscanf(s)) <= 80
    out = [out; str2double(fscanf(s))];

end
fclose(s); delete(s);

fileID = fopen('valores_temp.txt','w');
fprintf(fileID,'%f\n',out);
fclose(fileID);
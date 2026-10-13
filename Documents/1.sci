clc 
clear
clf
//plot vecrtor 2d and 3d 
//plot3d([-1,1],[-1,0],[-1,1])
//xarrows([0,1],[0,7],[0,5],5,1)
//x=1
//y=5
//r=sqrt(x^2+y^2)
//theta=(y(x)*(180/%pi))
//disp([r,theta])
//dis=y(x)
//disp(dis)
//scalar field 
///function a=sc(x,y)
   /// a=(x.^2).*y
//endfunction
//x=linspace(-5,5,100)
//y=linspace(-5,5,100)
//[X,Y]=meshgrid(x,y)
///a=sc(X,Y)
///surf(x,y,a)
///colorbar

//vector field
//function [a,b]=sc(x,y)
  //   a=x
    // b=y
//endfunction
//x=linspace(-5,5,100)
//y=linspace(-5,5,100)
//[X,Y]=meshgrid(x,y)
//[a,b]=sc(X,Y)
//champ(x,y,a,b,0.2,rect=[-2,-2,2,2])
//gce().colored="on"
///colorbar  
//vector field and li or not 
//a=[1,1,1;1,0,1]
//if rank(a)==size(a,2) then
//    disp("vector linearly independet")
//else
 //   disp("vector linearly dependet")    
//end
//xgrid()
//plot3d([0,5],[0,5],[0,10],"lines",1)
//for i=1:size(a,1)
 //   xarrows([0,a(i,1)],[0,a(i,2)],[0,a(i,3)],5,5)
//end
//rank nullity theorm 
//a=[4,5,9,-2;6,5,1,12;3,4,8,-3]
//r=rank(a)
//k=kernel(a)
//nuli=size(k,2)
//disp(r);disp(nuli)
//n=size(a,2)
//if r+nuli==n then
  //  disp("rank nu. theorm verified" )
//else 
  //  disp("r. nu. therom not verified")    
//end
//solution of equ.
//x+4y+7z=1 2x+5y+8z=2 x+2y+3z=1

//a=[1,1,3;4,0,8;2,2,3]
//b=[6;12;9]
//ab=[a,b]
//ra=rank(a)
//rb=rank(b)
//rab=rank(ab)
//n=size(a,2)
//disp("rank of cofficient matrix")
//disp(ra)
//disp("rank of arrgment martix ")
//disp(rab)
//disp(n)
//if  ra==rab then
//    if ra==n then
//        disp('uniqe solu')
//        x=inv(a)*b
//        disp("solution ")
//        disp(x)
//    else 
//        disp("infinite solution")
//     end   
//else 
  //  disp("no solu exist ")        
//end
//basis exist or not
//if rank==3 then forms basis 
//basis 211,1-11,101 coordine of v 421
//v=[2,1,1;1,-1,1;1,0,1]
//r=rank(v)
//if r==3 then
//    b=[4;2;1]
//    c=v\b
//    disp(c)
//end
//linear transformation 
//t(xyz)=(z+y y+z z+x)
//function v=t(x,y,z)
//    v=[x+y,y+z,z+x]
//endfunction
//e1=[1;0;0]
//e2=[0;1;0]
//e3=[0;0;1]
//t1=t(e1(1),e1(2),e1(3))
//t2=t(e2(1),e2(2),e2(3))
//t3=t(e3(1),e3(2),e3(3))
//a=[t1,t2,t3]
//disp(a)
//orthogonalization
n=input("enter number of vector ")
for i=1:n
    v(:,i)=input("enter vector ")    
end
disp(v)
w(:,1)=v(:,1)
for i=2:n
    sum=0
    for j=2:i
        sum=sum+((w(:,j-1)*v(:,i)')/(w(:,j-1)*w(:,j-1)'))*w(:,j-1)
    end
    w(:,i)=v(:,i)-sum    
end
a=null(n,n)
for i=1:n
    for j=i+1:n
        a(i,j)=w(:,i)'*w(:,j)
    end    
end
if a==null(n,n) then
    disp("v a o t e o")
end
disp("o s o v ")
for i=1:n
    disp(w(:,i)')
end
disp(a)
disp(null(n,n))


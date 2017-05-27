function wedge_creator(base,height){
var triangleGeometry = new THREE.Geometry(); 
triangleGeometry.vertices.push(new THREE.Vector3(-height/2,  base/2, 0.95));  
triangleGeometry.vertices.push(new THREE.Vector3(-height/2, -base/2, 0.95)); 
triangleGeometry.vertices.push(new THREE.Vector3( height/2, -base/2, 0.95));
triangleGeometry.vertices.push(new THREE.Vector3(-height/2,  base/2, 2.5));  
triangleGeometry.vertices.push(new THREE.Vector3(-height/2, -base/2, 2.5)); 
triangleGeometry.vertices.push(new THREE.Vector3( height/2, -base/2, 2.5));

triangleGeometry.faces.push(new THREE.Face3(0, 1, 2));
triangleGeometry.faces.push(new THREE.Face3(3, 4, 5));
// Points 1,4,3 and 6 form a rectangle which I'm trying to construct using triangles 0,2,5 and 0,3,5
triangleGeometry.faces.push(new THREE.Face3(0, 2, 5));
triangleGeometry.faces.push(new THREE.Face3(0, 3, 5));

triangleGeometry.faces.push(new THREE.Face3(0, 3, 4));
triangleGeometry.faces.push(new THREE.Face3(0, 1, 4));

triangleGeometry.faces.push(new THREE.Face3(1, 4, 2));
triangleGeometry.faces.push(new THREE.Face3(4, 5, 2));

var triangleMaterial = new THREE.MeshBasicMaterial({ 
color:0xFFFFFF, 
side:THREE.DoubleSide 
});

var triangleMesh = new THREE.Mesh(triangleGeometry, triangleMaterial); 
triangleMesh.position.set(1, 0.0, 0.0); 

scene.add(triangleMesh); 
return triangleMesh;
}
function cylinder_creator(radiusTop,radisBottom,height){
			var cylindergeometry = new THREE.CylinderGeometry(0.6,0.6,2,50, false);
			var cylindermaterial = new THREE.MeshBasicMaterial({wireframe: true, color: "red"});
			var cylinder = new THREE.Mesh(cylindergeometry, cylindermaterial);
			scene.add(cylinder);
			return cylinder;
}
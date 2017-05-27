function cone_creator(radiusBottom,height){
			var conegeometry = new THREE.CylinderGeometry(0,radiusBottom,height, 500, false);
			var conematerial = new THREE.MeshBasicMaterial({wireframe: true, color: 0xff0000});
			var cone = new THREE.Mesh(conegeometry, conematerial);
			scene.add(cone);
			return cone;
}
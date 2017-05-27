function Cuboid_creator(length,breadth,height){
			var geometry = new THREE.BoxGeometry( length,breadth,height );
			var material = new THREE.MeshBasicMaterial( { color: "green"} );
			var cuboid = new THREE.Mesh( geometry, material );
			scene.add( cuboid );
			return cuboid;
}
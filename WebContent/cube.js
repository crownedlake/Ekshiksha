function cube_creator(side){
			var geometry = new THREE.BoxGeometry( side,side,side );
			var material = new THREE.MeshBasicMaterial( { color: "red"} );
			var cube = new THREE.Mesh( geometry, material );
			scene.add( cube );
			return cube;
}
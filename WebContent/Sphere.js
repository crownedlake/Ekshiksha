function Sphere_creator(radius){
			var geometry = new THREE.SphereGeometry( radius,32,32 );
			var material = new THREE.MeshBasicMaterial( { color: "red"} );
			var obj = new THREE.Mesh( geometry, material );
			scene.add( obj );
			return obj;
}
#ifndef ADD_H_
//Always do this for .h files

#define ADD_H_
//Always do this for .h files
namespace math{
	template <typename T>
	static T add (T const& a, T const& b){ 
		//if using templates put cpp file inside of h file
		return a+b; 
	}
}

#endif //ADD_H_
//Always do this for .h files
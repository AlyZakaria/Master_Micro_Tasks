#include <iostream>
#include <bits/stdc++.h>

using namespace std;


vector<int> Matrix_Flatten(vector<vector<vector<int>>> vector_3D){


    int x = vector_3D.size();
    int y = vector_3D[0].size();
    int z = vector_3D[0][0].size();
    vector<int> res(x*y*z);

    for(int k = 0; k < z; k++){
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                res[i*y + j + x*y*k] = vector_3D[i][j][k];
                //cout << res[i*y + j + x*y*k] << " ";
            }
        }
    }


return res;
}


void display_vector1D(vector<int> vector_1D){

    cout << "---The Vector_1D Contents---" << endl;
    for(auto i : vector_1D)
        cout << i << " ";
}

void display_vector3D(vector<vector<vector<int>>> vector_3D){


    int x = vector_3D.size();
    int y = vector_3D[0].size();
    int z = vector_3D[0][0].size();

    /*if(x == 0 || y == 0 || z == 0)
        return;
*/
    cout << "---Vector_3D Contents---" << endl;
     for(int k = 0 ; k < z; k++){
            cout << "\nLayer " << k+1 << endl;
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                cout << vector_3D[i][j][k] << " ";
            }
            cout << endl;
        }
    }

    cout << endl;

}


int main()
{
    int n , m , p;
    bool flag = false;

do{
    cout << "Enter the size of matrix: " << endl;
    cin >> n >> m >> p;


    try{
        if(n == 0 || m == 0 || p == 0)
            throw exception();

    vector<vector<vector<int>>> vector_3D(n,vector<vector<int>>(m,vector<int>(p)));
    vector<int> vector_1D(n*m*p);
    int c = 0;
    cout << endl;


    for(int k = 0 ; k < p; k++){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                vector_3D[i][j][k] = c++;
            }
        }
    }

    display_vector3D(vector_3D);

    vector_1D = Matrix_Flatten(vector_3D);

    display_vector1D(vector_1D);
    flag = false;

    }catch(exception e){
        cout << "Invalid Input\n" << endl;
        flag = true;
    }

}while(flag);




    return 0;
}

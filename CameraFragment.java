package com.posep.isometricwellness;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.posep.isometricwellness.ui.ui.five.ImgViewModel5;
import com.posep.isometricwellness.ui.ui.four.ImgViewModel4;
import com.posep.isometricwellness.ui.ui.one.ImgViewModel;
import com.posep.isometricwellness.ui.ui.seven.ImgViewModel7;
import com.posep.isometricwellness.ui.ui.six.ImgViewModel6;
import com.posep.isometricwellness.ui.ui.three.ImgViewModel3;
import com.posep.isometricwellness.ui.ui.two.ImgViewModel2;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link com.posep.isometricwellness.CameraFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CameraFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //MY OWN ***
    Button camera;
    Button save;
    Bitmap bitmap;
    ImageView img;
    Bitmap newImage;
    int SELECT_CODE = 100;
    int CAMERA_CODE = 101;
    Bitmap bmp;
    boolean clicked;
    DrawerLayout drawerLayout2;
    ImageButton imageButton2;
    NavigationView navView;
    public static int count = 0;
    static boolean saveclicked = false;
   // private DatabaseReference root = FirebaseDatabase.getInstance().getReference("Image");
   // private StorageReference reference = FirebaseStorage.getInstance().getReference();

    Uri uri;
    private DatabaseReference view = FirebaseDatabase.getInstance().getReference("Image");
    private StorageReference reference = FirebaseStorage.getInstance().getReference();

    //MY OWN ***


    public CameraFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment com.posep.isometricwellness.CameraFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static com.posep.isometricwellness.CameraFragment newInstance(String param1, String param2) {
        com.posep.isometricwellness.CameraFragment fragment = new com.posep.isometricwellness.CameraFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_camera, container, false);

        camera = root.findViewById(R.id.Camera);
        save = root.findViewById(R.id.Confirm);
        img = root.findViewById(R.id.imageView);

        drawerLayout2 = root.findViewById(R.id.coordinatorLayout);
        imageButton2 = root.findViewById(R.id.buttonDrawerToggle);

        img.setImageResource(R.drawable.ph);
        bmp = ((BitmapDrawable) img.getDrawable()).getBitmap();


        getPermission();

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked = true;
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, CAMERA_CODE);
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) requireActivity()).openDrawer();
            }
        });


        return root;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_CODE & data != null) {
            bitmap = (Bitmap) data.getExtras().get("data");
            int dim = Math.min(bitmap.getWidth(), bitmap.getHeight());
            bitmap = ThumbnailUtils.extractThumbnail(bitmap, dim, dim);
            img.setImageBitmap(bitmap);


            if (clicked) {
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            Log.d("IMAGE", "IMAGE SENT");
                            count++;
                            saveclicked = true;

                            switch (count) {
                                case 1:
                                    ImgViewModel imgViewModel = new ViewModelProvider(requireActivity()).get(ImgViewModel.class);
                                    imgViewModel.setImageBitmap(bitmap);

                                    Toast.makeText(getContext(), "First Workout Saved! Navigate to the workout to see the results!", Toast.LENGTH_LONG).show();
                                    break;
                                case 2:
                                    ImgViewModel2 imgViewModel2 = new ViewModelProvider(requireActivity()).get(ImgViewModel2.class);
                                    imgViewModel2.setImageBitmap(bitmap);

                                    Toast.makeText(getContext(), "Second Workout Saved! Navigate to the workout to see the results!", Toast.LENGTH_LONG).show();
                                    break;
                                case 3:
                                    ImgViewModel3 imgViewModel3 = new ViewModelProvider(requireActivity()).get(ImgViewModel3.class);
                                    imgViewModel3.setImageBitmap(bitmap);

                                    Toast.makeText(getContext(), "Third Workout Saved! Navigate to the workout to see the results!", Toast.LENGTH_SHORT).show();
                                    break;
                                case 4:
                                    ImgViewModel4 imgViewModel4 = new ViewModelProvider(requireActivity()).get(ImgViewModel4.class);
                                    imgViewModel4.setImageBitmap(bitmap);

                                    Toast.makeText(getContext(), "Fourth Workout Saved! Navigate to the workout to see the results!", Toast.LENGTH_SHORT).show();
                                    break;
                                case 5:
                                    ImgViewModel5 imgViewModel5 = new ViewModelProvider(requireActivity()).get(ImgViewModel5.class);
                                    imgViewModel5.setImageBitmap(bitmap);

                                    Toast.makeText(getContext(), "Fifth Workout Saved! Navigate to the workout to see the results!", Toast.LENGTH_SHORT).show();
                                    break;
                                case 6:
                                    ImgViewModel6 imgViewModel6 = new ViewModelProvider(requireActivity()).get(ImgViewModel6.class);
                                    imgViewModel6.setImageBitmap(bitmap);

                                    Toast.makeText(getContext(), "Sixth Workout Saved! Navigate to the workout to see the results!", Toast.LENGTH_SHORT).show();
                                    break;
                                case 7:
                                    ImgViewModel7 imgViewModel7 = new ViewModelProvider(requireActivity()).get(ImgViewModel7.class);
                                    imgViewModel7.setImageBitmap(bitmap);

                                    Toast.makeText(getContext(), "Seventh Workout Saved! Navigate to the workout to see the results!", Toast.LENGTH_SHORT).show();
                                    camera.setEnabled(false);
                                    break;
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } else
                Toast.makeText(getContext(), "First Select a Photo", Toast.LENGTH_LONG).show();

        }

    }
    void getPermission() {
        if (ContextCompat.checkSelfPermission(requireContext(), android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{android.Manifest.permission.CAMERA}, 102);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 102 && grantResults.length > 0) {
            getPermission();
        }
    }
    public static int getCount(){
        return count;
    }
    public static boolean OpenWorkouts() {
        return saveclicked;
    }
}
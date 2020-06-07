package com.mygdx.game.utilities;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.entities.Player;

public class CameraUtilities {

    private CameraUtilities(){
        throw new AssertionError();
    }

    //Basic camera that follows the player
    public static void lockOnTarget(Camera camera, Vector2 target) {
        Vector3 position = camera.position;
        position.x = target.x;
        position.y = target.y;
        camera.position.set(position);
        camera.update();
    }

    //Basic Camera that lags behing the player but catches up
    public static void InterpolateToTarget(Camera camera, Vector2 target) {
        // a + (b - a) * lerp factor
        Vector3 position = camera.position;
        position.x = camera.position.x + (target.x - camera.position.x) * 0.06f;//0.1f to 0.075f
        position.y = camera.position.y + (target.y - camera.position.y) * 0.06f;
        camera.position.set(position);
        camera.update();
    }

    //Basic Camera that lags behing the player but catches up
    public static void TrainCamera(Camera camera, Vector2 target) {
        // a + (b - a) * lerp factor
        Vector3 position = camera.position;

//        position.y = camera.position.y + (target.y - camera.position.y) * 0.06f;
   position.y = 540;
        if(Player.getPlayer().getPostionX() < 1800){
//            position.x = 800;
            int avg = (1780 + Player.getPlayer().getPostionX())/2;
            position.x = camera.position.x + (avg - camera.position.x) * 0.06f;//0.1f to 0.075f

        }else if(Player.getPlayer().getPostionX() > 6800) {
            int avg = (6880 + Player.getPlayer().getPostionX())/2;
            position.x = camera.position.x + (avg - camera.position.x) * 0.06f;//0.1f to 0.075f
//            position.x = 7385;
            }
        else{
            position.x = camera.position.x + (target.x - camera.position.x) * 0.06f;//0.1f to 0.075f
        }
        camera.position.set(position);
        camera.update();
    }

    public static void lockAverageBetweenTargets(Camera camera, Vector2 targetA, Vector2 targetB) {
        Vector3 position = camera.position;
        position.x = (targetA.x + targetB.x) / 2;
        position.y = (targetA.y + targetB.y) / 2;
        camera.position.set(position);
        camera.update();
    }

    public static void InterpolateAverageBetweenTargets(Camera camera, Vector2 targetA, Vector2 targetB) {
        float avgX = (targetA.x + targetB.x) / 2;
        float avgY = (targetA.y + targetB.y) / 2;

        Vector3 position = camera.position;
        position.x = camera.position.x + (avgX - camera.position.x) * .1f;
        position.y = camera.position.y + (avgY - camera.position.y) * .1f;
        camera.position.set(position);
        camera.update();
    }

    public static boolean searchFocalPoints(OrthographicCamera camera, Array<Vector2> focalPoints, Vector2 target, float threshold) {
        for (Vector2 point : focalPoints) {
            if (target.dst(point) < threshold) {
                float newZoom = (target.dst(point) / threshold) + .2f;
                camera.zoom = camera.zoom + ((newZoom > 1 ? 1 : newZoom) - camera.zoom) * .1f;
                CameraUtilities.InterpolateToTarget(camera, point);
                return true;
            }
        }
        return false;
    }

    public static void shake(Camera camera, Vector2 displacement, float strength) {
        Vector3 position = camera.position;
        position.x += displacement.x * strength;
        position.y += displacement.y * strength;
        camera.position.set(position);
        camera.update();
    }
}


package com.stal111.compressed_items.util;

import java.util.Collection;

import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

public class VoxelshapeHelper {
	
	public static VoxelShape combineAll(final Collection<VoxelShape> shapes) {
        VoxelShape result = VoxelShapes.empty();
        for (final VoxelShape shape : shapes) {
            result = VoxelShapes.combine(result, shape, IBooleanFunction.OR);
        }
        return result.simplify();
    }
	
	public static VoxelShape combineAll(final VoxelShape... shapes) {
        VoxelShape result = VoxelShapes.empty();
        for (final VoxelShape shape : shapes) {
            result = VoxelShapes.combine(result, shape, IBooleanFunction.OR);
        }
        return result.simplify();
    }

}

package vktec.unpersistendermen.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import vktec.unpersistendermen.UnpersistEndermenMod;

@Mixin(EndermanEntity.class)
public abstract class EndermanEntityMixin extends HostileEntity {
    public EndermanEntityMixin(EntityType<? extends EndermanEntity> arg, World arg2) {
        super(arg, arg2);
    }

    @Redirect(method = "cannotDespawn", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/mob/EndermanEntity;getCarriedBlock()Lnet/minecraft/block/BlockState;"))
    public BlockState redirectCarriedBlock(EndermanEntity self) {
	    if (self.world.isClient || self.world.getGameRules().getBoolean(UnpersistEndermenMod.ENDERMEN_PERSIST)) {
			return self.getCarriedBlock();
	    } else {
		    return null;
	    }
    }
}

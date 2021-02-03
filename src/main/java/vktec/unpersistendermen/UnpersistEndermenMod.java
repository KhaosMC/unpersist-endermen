package vktec.unpersistendermen;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class UnpersistEndermenMod implements ModInitializer {
	public static GameRules.Key<GameRules.BooleanRule> ENDERMEN_PERSIST = GameRuleRegistry.register("endermenPersist", GameRules.Category.MOBS, GameRuleFactory.createBooleanRule(true));

	@Override
	public void onInitialize() {
	}
}

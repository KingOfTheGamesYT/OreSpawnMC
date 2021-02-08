/*     */ package danger.orespawn.items;
/*     */ 
/*     */ import danger.orespawn.OreSpawnMain;
/*     */ import danger.orespawn.entity.EntityCage;
/*     */ import danger.orespawn.init.ModItems;
/*     */ import java.util.ArrayList;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.passive.EntityHorse;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.SoundEvents;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ActionResult;
/*     */ import net.minecraft.util.EnumActionResult;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.SoundCategory;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CritterCage
/*     */   extends Item
/*     */ {
/*  50 */   private static final ArrayList<CritterCage> critterCages = new ArrayList<>();
/*     */ 
/*     */   
/*     */   private final float chance;
/*     */ 
/*     */   
/*     */   Class<? extends Entity> entityClass;
/*     */ 
/*     */   
/*     */   public CritterCage(Class<? extends Entity> entityClass, String unlocalizedName) {
/*  60 */     this(entityClass, unlocalizedName, 1.0F);
/*     */   }
/*     */   
/*     */   public CritterCage(Class<? extends Entity> entityClass, String unlocalizedName, float chance) {
/*  64 */     setUnlocalizedName(unlocalizedName);
/*  65 */     setRegistryName(unlocalizedName);
/*  66 */     setCreativeTab(OreSpawnMain.OreSpawnTab);
/*     */     
/*  68 */     this.maxStackSize = 16;
/*  69 */     this.entityClass = entityClass;
/*  70 */     this.chance = chance;
/*     */     
/*  72 */     ModItems.ITEMS.add(this);
/*  73 */     critterCages.add(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getChance() {
/*  78 */     return this.chance;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
/*  86 */     ItemStack stack = player.getHeldItem(hand);
/*     */     
/*  88 */     EnumActionResult result = handleRightClick(world, player, hand, player.getPosition(), false);
/*     */     
/*  90 */     if (result == EnumActionResult.SUCCESS && 
/*  91 */       !player.isCreative()) {
/*  92 */       stack.shrink(1);
/*     */     }
/*     */     
/*  95 */     return new ActionResult(result, stack);
/*     */   }
/*     */ 
/*     */   
/*     */   public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing blockside, float p_180614_6_, float p_180614_7_, float p_180614_8_) {
/* 100 */     EnumActionResult result = handleRightClick(world, player, hand, pos, true);
/* 101 */     if (result != EnumActionResult.FAIL && !player.isCreative()) {
/* 102 */       player.getHeldItem(hand).shrink(1);
/*     */     }
/* 104 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private EnumActionResult handleRightClick(World world, EntityPlayer entityPlayer, EnumHand hand, BlockPos position, boolean clickingOnBlock) {
/* 110 */     if (this.entityClass == null) {
/* 111 */       System.out.println("Throwing empty cage");
/* 112 */       if (!world.isRemote) {
/* 113 */         EntityCage ec = new EntityCage(world, entityPlayer, this.entityClass, null);
/* 114 */         ec.shoot((Entity)entityPlayer, entityPlayer.rotationPitch, entityPlayer.rotationYaw, 0.0F, 1.5F, 1.0F);
/* 115 */         world.spawnEntity((Entity)ec);
/*     */       } 
/*     */       
/* 118 */       world.playSound(entityPlayer, entityPlayer.getPosition(), SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 1.0F, 1.5F);
/* 119 */       return EnumActionResult.SUCCESS;
/*     */     } 
/*     */ 
/*     */     
/* 123 */     if (world.isRemote) return EnumActionResult.SUCCESS; 
/* 124 */     if (clickingOnBlock) {
/*     */       
/* 126 */       for (int i = 0; i < 6; i++) {
/* 127 */         world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (position.getX() + 0.5F), (position.getY() + 1.25F), (position.getZ() + 0.5F), 0.0D, 0.0D, 0.0D, new int[] { 0 });
/* 128 */         world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, (position.getX() + 0.5F), (position.getY() + 1.25F), (position.getZ() + 0.5F), 0.0D, 0.0D, 0.0D, new int[] { 0 });
/* 129 */         world.spawnParticle(EnumParticleTypes.REDSTONE, (position.getX() + 0.5F), (position.getY() + 1.25F), (position.getZ() + 0.5F), 0.0D, 0.0D, 0.0D, new int[] { 0 });
/*     */       } 
/* 131 */       world.playSound(entityPlayer, position, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, 1.0F, 1.5F);
/*     */       
/* 133 */       Entity summon = EntityList.newEntity(this.entityClass, world);
/*     */       
/* 135 */       summon.setPosition((position.getX() + 0.5F), (position.getY() + 1), (position.getZ() + 0.5F));
/*     */       
/* 137 */       if (this.entityClass == EntityHorse.class) {
/* 138 */         ((EntityHorse)summon).setHorseVariant(world.rand.nextInt());
/*     */       }
/*     */       
/* 141 */       world.spawnEntity(summon);
/*     */ 
/*     */       
/* 144 */       EntityItem empty = new EntityItem(world);
/* 145 */       empty.setItem(new ItemStack(ModItems.EMPTY_CAGE));
/* 146 */       empty.setPosition(position.getX(), position.getY(), position.getZ());
/* 147 */       world.spawnEntity((Entity)empty);
/*     */ 
/*     */       
/* 150 */       ItemStack stack = entityPlayer.getHeldItem(hand);
/*     */       
/* 152 */       if (summon instanceof net.minecraft.entity.EntityLiving && stack.hasDisplayName())
/* 153 */         summon.setCustomNameTag(stack.getDisplayName()); 
/* 154 */       return EnumActionResult.SUCCESS;
/*     */     } 
/* 156 */     if (!world.isRemote) {
/* 157 */       String name = null;
/* 158 */       if (entityPlayer.getHeldItem(hand).hasDisplayName())
/* 159 */         name = entityPlayer.getHeldItem(hand).getDisplayName(); 
/* 160 */       EntityCage ec = new EntityCage(world, entityPlayer, this.entityClass, name);
/* 161 */       ec.shoot((Entity)entityPlayer, entityPlayer.rotationPitch, entityPlayer.rotationYaw, 0.0F, 1.5F, 1.0F);
/* 162 */       world.spawnEntity((Entity)ec);
/*     */     } 
/*     */     
/* 165 */     world.playSound(entityPlayer, entityPlayer.getPosition(), SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 1.0F, 1.5F);
/* 166 */     return EnumActionResult.SUCCESS;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CritterCage getCageFromEntity(Entity e) {
/* 179 */     for (CritterCage cc : critterCages) {
/* 180 */       if (cc.entityClass == e.getClass()) {
/* 181 */         return cc;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 191 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawnmc_1.12-development_0.6-deobf.jar!\danger\orespawn\items\CritterCage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
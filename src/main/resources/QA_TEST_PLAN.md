# Mod QA Test Plan: Lucky Block

**Mod ID:** `luckyblock`
**Minecraft Version:** 1.21.1
**Generated:** 2025-12-29T11:12:51.591Z
**Total Tests:** 12

## Quick Commands

Copy-paste these commands to quickly test features:

```
/give @p luckyblock:worm_scale
/give @p luckyblock:worm_scales
/give @p luckyblock:minecraftslime_ball
/give @p luckyblock:refined_ingot
/summon luckyblock:giant_worm
```

## Items

### 🤖 Worm Scale Registration

**Command:** `/give @p luckyblock:worm_scale`

**Steps:**
1. Run: /give @p luckyblock:worm_scale
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Worm Scales Registration

**Command:** `/give @p luckyblock:worm_scales`

**Steps:**
1. Run: /give @p luckyblock:worm_scales
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Minecraftslime Ball Registration

**Command:** `/give @p luckyblock:minecraftslime_ball`

**Steps:**
1. Run: /give @p luckyblock:minecraftslime_ball
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

### 🤖 Refined Ingot Registration

**Command:** `/give @p luckyblock:refined_ingot`

**Steps:**
1. Run: /give @p luckyblock:refined_ingot
2. Verify item appears in inventory
3. Check item texture is not purple/black
4. Hover to verify name displays correctly

**Expected:** Item appears with correct texture and localized name

- [ ] PASS
- [ ] FAIL: _________________

## Recipes

### 👤 Worm Scale Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:stick","minecraft:stick"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Worm Scale

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Worm Scales Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:stick","luckyblock:refined_ingot"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Worm Scales

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Minecraftslime Ball Crafting

**Steps:**
1. Open crafting table
2. Arrange ingredients: ["minecraft:stick","luckyblock:refined_ingot"]
3. Verify recipe shows in recipe book
4. Craft the item

**Expected:** Successfully craft Minecraftslime Ball

- [ ] PASS
- [ ] FAIL: _________________

## Blocks

### 👤 Lucky Block Placement

**Command:** `/give @p luckyblock:lucky_block`

**Steps:**
1. Run: /give @p luckyblock:lucky_block
2. Place block in world
3. Verify block texture is correct
4. Break block and verify drops

**Expected:** Block places with correct texture and drops correctly

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Minecraftstone Placement

**Command:** `/give @p luckyblock:minecraftstone`

**Steps:**
1. Run: /give @p luckyblock:minecraftstone
2. Place block in world
3. Verify block texture is correct
4. Break block and verify drops

**Expected:** Block places with correct texture and drops correctly

- [ ] PASS
- [ ] FAIL: _________________

## Mobs

### 🤖 Giant Worm Spawn

**Command:** `/summon luckyblock:giant_worm`

**Steps:**
1. Run: /summon luckyblock:giant_worm
2. Verify mob spawns without crash
3. Check mob texture is not purple/black
4. Verify mob has expected health

**Expected:** Mob spawns with correct model and attributes

- [ ] PASS
- [ ] FAIL: _________________

### 👤 Giant Worm AI Behavior

**Steps:**
1. Summon mob: /summon luckyblock:giant_worm
2. Approach mob (should be passive)
3. Observe movement patterns
4. Check mob responds to player presence

**Expected:** Mob ignores or flees from player

- [ ] PASS
- [ ] FAIL: _________________

## Mob Drops

### 👤 Giant Worm Loot

**Steps:**
1. Summon mob: /summon luckyblock:giant_worm
2. Kill the mob (use /kill if needed)
3. Collect dropped items
4. Verify drops match expected loot table

**Expected:** Drops: luckyblock:worm_scales, luckyblock:minecraftslime_ball

- [ ] PASS
- [ ] FAIL: _________________

## Test Summary

| Category | Tests | Passed | Failed |
|----------|-------|--------|--------|
| Items | 4 | [ ] | [ ] |
| Recipes | 3 | [ ] | [ ] |
| Blocks | 2 | [ ] | [ ] |
| Mobs | 2 | [ ] | [ ] |
| Mob Drops | 1 | [ ] | [ ] |

**Overall Result:** [ ] PASS / [ ] FAIL

**Notes:**

_Add any issues or observations here_
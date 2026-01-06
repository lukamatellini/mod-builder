# QA Test Plan: Lucky Loot Blocks

Generated: 2026-01-06T22:43:13.114Z
Minecraft Version: 1.21.1
Mod ID: luckylootblocks

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 25 |
| Passed | 14 |
| Failed | 5 |
| Warnings | 3 |
| Skipped | 3 |
| **Overall** | **FAILED** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `luckylootblocks.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Lucky Block | `/give @p luckylootblocks:lucky_block_item` | ☐ | ☐ | ☐ |
| Zombie | `/give @p luckylootblocks:zombie` | ☐ | ☐ | ☐ |
| Enderman | `/give @p luckylootblocks:enderman` | ☐ | ☐ | ☐ |

### Item Tests

#### Lucky Block

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Lucky Block"
- [ ] Crafting recipe works

#### Zombie

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Zombie"

#### Enderman

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Enderman"

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Lucky Block | `/give @p luckylootblocks:lucky_block` | ☐ | ☐ | ☐ |

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
